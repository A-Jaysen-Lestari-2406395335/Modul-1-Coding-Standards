## Eshop

---
Jaysen Lestari 3406395335

---
### Reflection 1
> You already implemented two new features using Spring Boot. Check again your source code
and evaluate the coding standards that you have learned in this module. Write clean code
principles and secure coding practices that have been applied to your code. If you find any
mistake in your source code, please explain how to improve your code. Please write your
reflection inside the repository's README.md file.

Setelah mengimplementasikan dua fitur baru menggunakan Spring Boot, saya mempelajari dan menerapkan beberapa konsep baru dalam penulisan source code. Saya menggunakan penamaan variabel dan fungsi yang jelas sesuai dengan fungsinya, serta memastikan setiap fungsi hanya memiliki satu tanggung jawab agar kode tetap mudah dibaca.

Dalam pengembangan fitur edit dan delete, saya menjaga konsistensi dengan struktur kode yang sudah ada, khususnya mengikuti pola dari fitur create. Saya juga menerapkan prinsip DRY (Don't Repeat Yourself) untuk menghindari duplikasi kode.

Penggunaan feature branch workflow membantu saya mengelola perubahan kode dengan lebih rapi dibandingkan langsung melakukan commit ke branch main. Namun, saya menyadari masih ada kekurangan pada sisi keamanan. Saat ini, siapa pun dapat melakukan delete produk melalui enumerasi atau brute force. Ke depannya, diperlukan sistem autentikasi dan autorisasi agar hanya pengguna yang membuat produk yang dapat menghapusnya.

---
### Reflection 2
> 1. After writing the unit test, how do you feel? How many unit tests should be made in a
     class? How to make sure that our unit tests are enough to verify our program? It would be
     good if you learned about code coverage. Code coverage is a metric that can help you
     understand how much of your source is tested. If you have 100% code coverage, does
     that mean your code has no bugs or errors?

Setelah membuat unit test, saya menjadi lebih percaya dengan kualitas dan kebenaran kode yang saya tulis. Selain itu, saya juga menyadari bahwa unit test ini cukup penting dalam pemrograman dengan skala yang besar. Karena dengan adanya unit test, developer dapat secara signifikan mengurangi dan meminimalisir terjadinya suatu bug atau error, sehingga mereka dapat menghemat waktu dalam pengembangan aplikasi.

Terkait bagaimana cara kita mengetahui apakah unit test yang kita miliki sudah cukup, menurut saya, tidak ada standard tertentu yang mengatur jumlah unit test yang baik pada suatu program, karena hal tersebut tergantung pada kompleksitas dan juga edge case pada program yang kita miliki. Secara umum, agar kode yang kita miliki terverifikasi engan baik oleh unit test, sebaiknya kita membuat satu atau lebih pengujian yang mencakup berbagai kemungkinan, misalnya melakukan pengujian ketika input tidak sesuai dengan tipe data yang telah ditentukan, sehingga kita bisa meminimalisir adanya bug pada program kita.

Kemudian, mengenai code coverage, 100% code coverage tidak berarti bahwa code kita telah bebas dari bug ataupun error. Hal ini dikarenakan code coverage hanya menghitung berdasarkan eksekusi yang terjadi, bukan berdasarkan kebenaran logika program yang kita miliki. Sehingga, tidak jarang masih terdapat bug atau error pada program dengan code coverage yang tinggi, karena perhitungan code coverage hanya menyesuaikan dengan code yang kita miliki, bukan berarti logika dari kode kita juga pasti benar.

> 2. Suppose that after writing the CreateProductFunctionalTest.java along with the
   corresponding test case, you were asked to create another functional test suite that
   verifies the number of items in the product list. You decided to create a new Java class
   similar to the prior functional test suites with the same setup procedures and instance
   variables.
   What do you think about the cleanliness of the code of the new functional test suite? Will
   the new code reduce the code quality? Identify the potential clean code issues, explain
   the reasons, and suggest possible improvements to make the code cleaner! Please write
   your reflection inside the repository's README.md file.

Menurut saya, pembuatan kelas functional test baru yang memiliki konfigurasi dan variabel serupa melanggar prinsip DRY (Don't Repeat Yourself). Kondisi ini menyebabkan kode menjadi kurang rapi dan menurunkan kualitas kode karena banyak terjadi duplikasi. Untuk mengatasi hal tersebut, kita dapat membuat sebuah base test class yang berisi inisialisasi variabel umum serta konfigurasi yang dapat digunakan kembali. Selanjutnya, setiap functional test yang dibutuhkan dapat mewarisi atau memanfaatkan base class tersebut. Pendekatan ini membuat pengelolaan dan pemeliharaan kode test menjadi lebih mudah, karena perubahan cukup dilakukan pada satu tempat saja. Selain itu, penambahan test case baru dapat dilakukan dengan lebih cepat tanpa perlu menulis ulang kode yang sama, sekaligus menjaga konsistensi struktur dan setup antar test class.