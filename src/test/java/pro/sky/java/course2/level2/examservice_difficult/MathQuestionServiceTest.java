package pro.sky.java.course2.level2.examservice_difficult;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.level2.examservice_difficult.exeption.QuestionExistException;
import pro.sky.java.course2.level2.examservice_difficult.exeption.QuestionNotExistException;
import pro.sky.java.course2.level2.examservice_difficult.repository.MathQuestionRepository;
import pro.sky.java.course2.level2.examservice_difficult.serviceimpl.MathQuestionService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.level2.examservice_difficult.JavaQuestionConstant.*;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository mathQuestionRepositoryMock;

    @InjectMocks
    private MathQuestionService out;

    @Test
    public void shouldCallRepositoryMethodWhenAddRemoveElement() {
        when(mathQuestionRepositoryMock.add(MATH_QUESTION_1, MATH_ANSWER_1))
                .thenReturn(QUESTION_WAS_ADDED_1);
        when(mathQuestionRepositoryMock.remove(QUESTION_WAS_REMOVED_3))
                .thenReturn(QUESTION_WAS_REMOVED_3);

        assertEquals(QUESTION_WAS_ADDED_1, out.add(MATH_QUESTION_1, MATH_ANSWER_1));
        assertEquals(QUESTION_WAS_REMOVED_3, out.remove(QUESTION_WAS_REMOVED_3));
    }

    @Test
    void shouldQuestionExceptionWasChecked() {
        when(mathQuestionRepositoryMock.add(MATH_QUESTION_3, MATH_ANSWER_3))
                .thenThrow(QuestionExistException.class);
        when(mathQuestionRepositoryMock.remove(QUESTION_WAS_ADDED_1))
                .thenThrow(QuestionNotExistException.class);

        assertThrows(QuestionNotExistException.class, () -> out.remove(QUESTION_WAS_ADDED_1));
        assertThrows(QuestionExistException.class, () -> out.add(MATH_QUESTION_3, MATH_ANSWER_3));
    }

    @Test
    void shouldAllQuestionsWasGiven() {
        when(mathQuestionRepositoryMock.getAll()).thenReturn(MATH_REPOSITORY);
        assertTrue(MATH_REPOSITORY_TRUE.values().size() == out.getAll().size() &&
                MATH_REPOSITORY_TRUE.values().containsAll(out.getAll()));

    }
}
