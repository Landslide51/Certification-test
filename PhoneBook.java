import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        List<String> phoneList = contacts.getOrDefault(name, new ArrayList<>());
        phoneList.add(phone);
        contacts.put(name, phoneList);
    }

    public List<Map.Entry<String, List<String>>> sortContactsByPhoneCount() {
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(contacts.entrySet());

        Collections.sort(sortedContacts, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
                return Integer.compare(entry2.getValue().size(), entry1.getValue().size());
            }
        });

        return sortedContacts;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Maria", "9998887755");
        phoneBook.addContact("Danil", "9897894566");
        phoneBook.addContact("Maria", "1111111111");
        phoneBook.addContact("Danil", "8527413654");

        List<Map.Entry<String, List<String>>> sortedContacts = phoneBook.sortContactsByPhoneCount();

        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
