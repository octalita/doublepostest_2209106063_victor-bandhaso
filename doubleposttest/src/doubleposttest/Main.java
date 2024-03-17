package doubleposttest;

import java.util.ArrayList;
import java.util.Scanner;

// Class untuk menyimpan data user
class User {
    private String username;
    private String password;
    private String nama;
    private int umur;
    private String alamat;
    private String pekerjaan;
    private ArrayList<String> additionalData;

    // Constructor
    public User(String username, String password, String nama, int umur, String alamat, String pekerjaan) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.pekerjaan = pekerjaan;
        this.additionalData = new ArrayList<>();
    }

    // Getter untuk username
    public String getUsername() {
        return username;
    }

    // Getter untuk password
    public String getPassword() {
        return password;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter untuk umur
    public int getUmur() {
        return umur;
    }

    // Getter untuk alamat
    public String getAlamat() {
        return alamat;
    }

    // Getter untuk pekerjaan
    public String getPekerjaan() {
        return pekerjaan;
    }

    // Method untuk menambah data tambahan
    public void addAdditionalData(String data) {
        additionalData.add(data);
    }

    // Method untuk mendapatkan data tambahan
    public ArrayList<String> getAdditionalData() {
        return additionalData;
    }
}

// Class untuk melakukan login dan registrasi
class LoginRegistrationSystem {
    private User currentUser;

    // Method untuk melakukan login
    public void login(String username, String password) {
        if (currentUser != null) {
            System.out.println("Seseorang sudah masuk. Logout terlebih dahulu.");
            return;
        }

        // Di sini perlu mencari user dengan username yang sesuai
        // Misalnya, kita memiliki kumpulan user yang tersimpan di ArrayList
        // Di sini kita akan asumsikan bahwa daftar user ini didefinisikan di tempat lain

        // Setelah menemukan user dengan username yang sesuai, kita bisa lanjutkan dengan pengecekan password
        // Untuk contoh ini, kita akan asumsikan bahwa user ditemukan dan password cocok

        // Contoh implementasi sederhana:
        if ("admin".equals(username) && "admin123".equals(password)) {
            currentUser = new User("admin", "admin123", "Admin", 30, "Alamat Admin", "Pekerjaan Admin");
            System.out.println("Login berhasil. Selamat datang, " + currentUser.getNama() + "!");
            // Menampilkan home page setelah login berhasil
            displayHomePage();
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }

    // Method untuk melakukan registrasi
    public void register(String username, String password) {
        if (currentUser != null) {
            System.out.println("Seseorang sudah masuk. Logout terlebih dahulu.");
            return;
        }

        // Logika registrasi baru

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan umur: ");
        int umur = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline di buffer
        System.out.print("Masukkan alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan pekerjaan: ");
        String pekerjaan = scanner.nextLine();

        currentUser = new User(username, password, nama, umur, alamat, pekerjaan);
        System.out.println("Registrasi berhasil. Selamat datang, " + currentUser.getNama() + "!");
        // Meminta dan menyimpan data tambahan dari pengguna saat registrasi
        System.out.println("Masukkan minimal 5 data tambahan:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Data " + (i + 1) + ": ");
            String data = scanner.nextLine();
            currentUser.addAdditionalData(data);
        }

        scanner.close();
    }

    // Method untuk logout
    public void logout() {
        if (currentUser == null) {
            System.out.println("Tidak ada yang masuk.");
        } else {
            System.out.println("Logout berhasil. Sampai jumpa, " + currentUser.getNama() + "!");
            currentUser = null;
        }
    }

    // Method untuk menampilkan home page
    private void displayHomePage() {
        System.out.println("Home Page");
        System.out.println("Data Anda:");
        System.out.println("Nama: " + currentUser.getNama());
        System.out.println("Umur: " + currentUser.getUmur());
        System.out.println("Alamat: " + currentUser.getAlamat());
        System.out.println("Pekerjaan: " + currentUser.getPekerjaan());
        System.out.println("Data Tambahan:");

        for (String data : currentUser.getAdditionalData()) {
            System.out.println("- " + data);
        }
    }
}

// Kelas utama untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginRegistrationSystem system = new LoginRegistrationSystem();

        // Menampilkan pesan untuk memasukkan NIM
        System.out.println("Masukkan NIM Anda:");
        int nim = scanner.nextInt();

        // Menentukan jenis sistem berdasarkan sisa pembagian nim dengan 3
        String systemType;
        if (nim % 3 == 0) {
            systemType = "Sistem Login dan Registrasi Facebook";
        } else if (nim % 3 == 1) {
            systemType = "Sistem Login dan Registrasi Genshin Impact";
        } else {
            systemType = "Sistem Login dan Registrasi Mobile Banking";
        }

        // Menampilkan jenis sistem
        System.out.println(systemType);

        // Lakukan operasi login atau registrasi sesuai pilihan pengguna
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Login");
            System.out.println("2. Registrasi");
            System.out.println("3. Logout");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline di buffer

            switch (choice) {
                case 1:
                    System.out.print("Masukkan username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String loginPassword = scanner.nextLine();
                    system.login(loginUsername, loginPassword);
                    break;
                case 2:
                    System.out.print("Masukkan username baru: ");
                    String registerUsername = scanner.nextLine();
                    System.out.print("Masukkan password baru: ");
                    String registerPassword = scanner.nextLine();
                    system.register(registerUsername, registerPassword);
                    break;
                case 3:
                    system.logout();
                    break;
                case 4:
                    System.out.println("Terima kasih. Program selesai.");
                    scanner.close(); // Menutup scanner
                    System.exit(0); // Keluar dari program
                default:
                    System.out.println("Menu tidak valid. Silakan pilih lagi.");
            }
        }
    }
}
