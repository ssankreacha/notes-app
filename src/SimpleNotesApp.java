import java.io.*;
import java.util.*;

class Note implements Serializable {
    private String title;
    private String content;
    private Date createdAt;

    // Constructor
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
    }

    // Getters
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Date getCreatedAt() { return createdAt; }

    // Setters
    public void setContent(String content) { this.content = content; }

    // Word count method
    public int getWordCount() {
        return content.trim().split("\\s+").length;
    }

    // Simple Encryption (Basic Encoding)
    public String getEncodedContent() {
        return Base64.getEncoder().encodeToString(content.getBytes());
    }

    // ToString for displaying notes
    @Override
    public String toString() {
        return "📌 Title: " + title +
                "\n🗓 Date: " + createdAt +
                "\n📃 Words: " + getWordCount() +
                "\n🔐 Encrypted Content: " + getEncodedContent() +
                "\n-------------------------------------";
    }
}

public class SimpleNotesApp {
    private static List<Note> notes = new ArrayList<>();
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        loadFromFile();  // Load existing notes
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📌 Simple Notes App");
            System.out.println("1️⃣ Create Note");
            System.out.println("2️⃣ View Notes");
            System.out.println("3️⃣ Edit Note");
            System.out.println("4️⃣ Delete Note");
            System.out.println("5️⃣ Search Notes");
            System.out.println("6️⃣ Sort Notes Alphabetically");
            System.out.println("7️⃣ Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createNote(scanner);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    editNote(scanner);
                    break;
                case 4:
                    deleteNote(scanner);
                    break;
                case 5:
                    searchNote(scanner);
                    break;
                case 6:
                    sortNotes();
                    break;
                case 7:
                    saveToFile();
                    System.out.println("✅ Notes saved. Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠ Invalid choice! Try again.");
            }
        }
    }

    // Create a new note
    private static void createNote(Scanner scanner) {
        System.out.print("Enter note title: ");
        String title = scanner.nextLine();
        System.out.print("Enter note content: ");
        String content = scanner.nextLine();

        notes.add(new Note(title, content));
        saveToFile();
        System.out.println("✅ Note saved successfully!");
    }

    // View all notes
    private static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("⚠ No notes found!");
            return;
        }
        notes.forEach(System.out::println);
    }

    // Edit a note
    private static void editNote(Scanner scanner) {
        System.out.print("Enter the title of the note to edit: ");
        String title = scanner.nextLine();
        for (Note note : notes) {
            if (note.getTitle().equalsIgnoreCase(title)) {
                System.out.print("Enter new content: ");
                String newContent = scanner.nextLine();
                note.setContent(newContent);
                saveToFile();
                System.out.println("✅ Note updated successfully!");
                return;
            }
        }
        System.out.println("⚠ Note not found!");
    }

    // Delete a note
    private static void deleteNote(Scanner scanner) {
        System.out.print("Enter the title of the note to delete: ");
        String title = scanner.nextLine();
        notes.removeIf(note -> note.getTitle().equalsIgnoreCase(title));
        saveToFile();
        System.out.println("❌ Note deleted successfully!");
    }

    // Search for a note by title
    private static void searchNote(Scanner scanner) {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        for (Note note : notes) {
            if (note.getTitle().equalsIgnoreCase(title)) {
                System.out.println("🔍 Found Note:\n" + note);
                return;
            }
        }
        System.out.println("⚠ No matching note found!");
    }

    // Sort notes alphabetically by title
    private static void sortNotes() {
        notes.sort(Comparator.comparing(Note::getTitle));
        saveToFile();
        System.out.println("✅ Notes sorted alphabetically!");
    }

    // Save notes to a file
    private static void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(notes);
        } catch (IOException e) {
            System.out.println("❌ Error saving notes!");
        }
    }

    // Load notes from a file
    private static void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            notes = (List<Note>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            notes = new ArrayList<>(); // Start fresh if file doesn't exist
        }
    }
}
