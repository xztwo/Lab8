import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        // Массив слов
        String[] words = {"Груша", "Груша", "Груша", "Яблоко", "Вишня", "Вишня", "Вишня", "Арбуз", "Арбуз", "Арбуз"};

        // Нахождение и вывод самых повторяющихся слов
        System.out.println(Arrays.stream(words)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))    // Группировка слов и подсчет частоты
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().intValue() == Arrays.stream(words)    // Фильтр по максимальному количеству повторений
                        .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .map(Map.Entry::getValue)
                        .max(Long::compare)
                        .orElse(0L)
                        .intValue())
                .map(Map.Entry::getKey)    // Извлечение слов
                .sorted()    // Сортировка
                .collect(Collectors.joining(", ", "Самые повторяющиеся слова: ", "!"))); // Собираем слова в одну строку
    }
}
