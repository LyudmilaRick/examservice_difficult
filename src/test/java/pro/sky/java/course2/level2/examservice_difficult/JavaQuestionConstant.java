package pro.sky.java.course2.level2.examservice_difficult;

import pro.sky.java.course2.level2.examservice_difficult.domain.Question;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class JavaQuestionConstant {
    public static final String MATH_QUESTION_1 = "число Эйлера";
    public static final String MATH_QUESTION_3 = "5*5";
    public static final String JAVA_QUESTION_1 = "StringBuilder";
    public static final String JAVA_QUESTION_3 = "Массив";


    public static final String MATH_ANSWER_1 = "2,71828182845904523536";
    public static final String MATH_ANSWER_3 = "25";
    public static final String JAVA_ANSWER_1 = "изменяет сам себя, а не создает новый измененный объект и возвращает его";
    public static final String JAVA_ANSWER_3 = "это упорядоченная структура данных фиксированного размера.";

    public static final Question QUESTION_WAS_ADDED_1 = new Question(
            "число Эйлера", "2,71828182845904523536");
    public static final Question QUESTION_WAS_ADDED_12 = new Question(
            "StringBuilder", " изменяет сам себя, а не создает новый измененный объект и возвращает его");
    public static final Question QUESTION_WAS_REMOVED_3 = new Question(
            "5*5", "25");
    public static final Question QUESTION_WAS_REMOVED_32 = new Question(
            "Массив", "это упорядоченная структура данных фиксированного размера.");

    public static final Collection<Question> MATH_REPOSITORY = List.of(
            new Question("Число пи", "3,1415926535"),
            new Question("2**8", "256"),
            new Question("lg1000", "3"),
            new Question("5*5", "25")
    );
    public static final Map<String, Question> MATH_REPOSITORY_TRUE = Map.ofEntries(
            Map.entry("Число пи", new Question("Число пи", "3,1415926535")),
            Map.entry("2**8", new Question("2**8", "256")),
            Map.entry("lg1000", new Question("lg1000", "3")),
            Map.entry("5*5", new Question("5*5", "25"))
    );

    public static final Collection<Question> JAVA_REPOSITORY = List.of(
            new Question("Полиморфизм", "это свойство, позволяющее " +
                                 "с помощью одного интерфейса обращаться к общему классу действий"),
            new Question("Инкапсуляция", " разграничение доступа к данным и возможностям классов и объектов"),
            new Question("Наследование", " это процесс, в ходе которого один объект приобретает свойства другого объекта"),
            new Question("Массив", "это упорядоченная структура данных фиксированного размера."),
            new Question("Switch", "это переключатель, который обеспечивает многовариантное ветвление программы.")
    );
    public static final Map<String, Question> JAVA_REPOSITORY_TRUE = Map.ofEntries(
            Map.entry("Полиморфизм", new Question("Полиморфизм", "это свойство, позволяющее " +
                                      "с помощью одного интерфейса обращаться к общему классу действий")),
            Map.entry("Инкапсуляция", new Question("Инкапсуляция", " разграничение доступа к данным и возможностям классов и объектов")),
            Map.entry("Наследование", new Question("Наследование", " это процесс, в ходе которого один объект приобретает свойства другого объекта")),
            Map.entry("Массив", new Question("Массив", "это упорядоченная структура данных фиксированного размера.")),
            Map.entry("Switch", new Question("Switch", "это переключатель, который обеспечивает многовариантное ветвление программы."))
    );
}
