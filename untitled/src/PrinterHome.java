import java.util.*;

public class PrinterHome {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        String[][] contacts = {
                {"Alice", "123456"},
                {"Bob", "789012"},
                {"Alice", "654321"},
                {"Charlie", "555555"},
                {"Charlie", "384763287"},
                {"Bob", "03945"},
                {"Charlie", "872364"},
                {"Shown", "28936487152"}
        };

        for (String[] contact : contacts) {
            String name = contact[0];
            String phoneNumber = contact[1];

            Set<String> phoneNumbers = phoneBook.getOrDefault(name, new HashSet<>());
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }

        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}