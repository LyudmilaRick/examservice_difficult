package pro.sky.java.course2.level2.examservice_difficult;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.level2.examservice_difficult.exeption.QuestionExistException;
import pro.sky.java.course2.level2.examservice_difficult.exeption.QuestionNotExistException;
import pro.sky.java.course2.level2.examservice_difficult.repository.JavaQuestionRepository;
import pro.sky.java.course2.level2.examservice_difficult.serviceimpl.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.level2.examservice_difficult.JavaQuestionConstant.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepositoryMock;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void shouldCallRepositoryMethodWhenAddRemoveElement() {
        when(javaQuestionRepositoryMock.add(JAVA_QUESTION_1, JAVA_ANSWER_1))
                .thenReturn(QUESTION_WAS_ADDED_12);
        when(javaQuestionRepositoryMock.remove(QUESTION_WAS_REMOVED_32))
                .thenReturn(QUESTION_WAS_REMOVED_32);

        assertEquals(QUESTION_WAS_ADDED_12, out.add(JAVA_QUESTION_1, JAVA_ANSWER_1));
        assertEquals(QUESTION_WAS_REMOVED_32, out.remove(QUESTION_WAS_REMOVED_32));
    }

    @Test
    void shouldQuestionExceptionWasChecked() {
        when(javaQuestionRepositoryMock.add(JAVA_QUESTION_3, JAVA_ANSWER_3))
                .thenThrow(QuestionExistException.class);
        when(javaQuestionRepositoryMock.remove(QUESTION_WAS_ADDED_12))
                .thenThrow(QuestionNotExistException.class);

        assertThrows(QuestionNotExistException.class, () -> out.remove(QUESTION_WAS_ADDED_12));
        assertThrows(QuestionExistException.class, () -> out.add(JAVA_QUESTION_3, JAVA_ANSWER_3));
    }

    @Test
    void shouldAllQuestionsWasGiven() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(JAVA_REPOSITORY);
        assertTrue(JAVA_REPOSITORY_TRUE.values().size() == out.getAll().size() &&
                JAVA_REPOSITORY_TRUE.values().containsAll(out.getAll()));

    }

}
