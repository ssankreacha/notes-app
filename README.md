# 📝 Simple Notes App (Java)

## 📌 Overview
The **Simple Notes App** is a **Java-based console application** that allows users to **create, view, edit, delete, and search notes**. It also **saves notes to a file (`notes.txt`)**, ensuring that notes are **persisted across sessions**.

---

## 🚀 Features
✅ **Create Notes** – Add new notes with a title and content  
✅ **View Notes** – Display all saved notes with **date & word count**  
✅ **Edit Notes** – Modify an existing note's content  
✅ **Delete Notes** – Remove notes by title  
✅ **Search Notes** – Find notes by title  
✅ **Sort Notes Alphabetically** – Arrange notes by title  
✅ **Basic Encryption (Base64 Encoding)** – Encrypts note content for privacy  
✅ **Save & Load Notes Automatically** – Data is stored persistently in `notes.txt`

---


---

## 🏗️ How It Works

### **1️⃣ Create a Note**
- Enter a title and content.
- The note is saved with the current **timestamp & word count**.

### **2️⃣ View Notes**
- Lists all notes with their **date & encrypted content**.

### **3️⃣ Edit a Note**
- Modify an existing note by **title**.

### **4️⃣ Delete a Note**
- Remove an unwanted note by **title**.

### **5️⃣ Search for a Note**
- Find a note by entering its **title**.

### **6️⃣ Sort Notes**
- Notes are sorted **alphabetically by title**.

### **7️⃣ Exit**
- Saves all notes to **`notes.txt`** before quitting.

---

## 🛠️ Technologies Used
✅ **Java (JDK 8+)** – Core logic  
✅ **File Handling** – Save & load notes (`ObjectOutputStream`, `ObjectInputStream`)  
✅ **Base64 Encoding** – Simple encryption for note content

---

## Future Enhancements
- 🚀 GUI version using JavaFX or Swing
- 🚀 Database Integration with MySQL
- 🚀 Cloud Storage for Notes

