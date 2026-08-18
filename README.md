# Tugas 11: Android Internet & Permissions (Android Development)

---

## 👤 1. Identitas Lengkap

* **Nama**: Anasufi Ajwa Nazli Nailulhaq
* **NIM**: 452024611015
* **Repository**: 

---

## 🔐 2. Perbedaan Karakteristik: Normal Permission vs Dangerous Permission

Dalam arsitektur keamanan Android, izin (*permission*) dikategorikan ke dalam beberapa tingkatan perlindungan (*protection level*). Berdasarkan materi yang dipelajari, berikut adalah perbandingan karakteristik utama antara **Normal Permission** dan **Dangerous Permission** dari sudut pandang interaksi pengguna (*runtime prompt*):

### 🌐 Normal Permission (Contoh: Akses Internet / `android.permission.INTERNET`)
* **Tingkat Risiko**: Rendah. Izin ini mencakup area di mana aplikasi perlu mengakses data atau fitur di luar sandbox-nya, tetapi hanya menghadirkan sedikit risiko terhadap privasi pengguna atau operasi perangkat lain.
* **Interaksi Pengguna (Runtime Prompt)**: **TIDAK ADA prompt/dialog interaktif saat aplikasi berjalan (*No Runtime Prompt*)**.
* **Mekanisme Persetujuan**:
  * Pengguna **secara otomatis memberikan izin** ini saat menginstal atau memperbarui aplikasi dari Google Play Store / APK.
  * Aplikasi cukup mendaftarkan izin ini di dalam berkas `AndroidManifest.xml`:
    ```xml
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    ```
  * Pengguna tidak terganggu oleh pop-up konfirmasi saat aplikasi sedang dioperasikan.

---

### ⚠️ Dangerous Permission (Contoh: Kamera, Lokasi, Kontak, Penyimpanan)
* **Tingkat Risiko**: Tinggi. Izin ini memberikan aplikasi akses ke data pribadi sensitif pengguna (seperti riwayat lokasi, kontak, foto) atau kontrol atas perangkat yang dapat mengganggu pengalaman pengguna (seperti mikrofon atau kamera).
* **Interaksi Pengguna (Runtime Prompt)**: **WAJIB menggunakan Runtime Prompt (Dialog Interaktif)** pada Android 6.0 (API level 23) ke atas.
* **Mekanisme Persetujuan**:
  * Pengguna **TIDAK otomatis memberikan izin** saat instalasi.
  * Ketika aplikasi membutuhkan fitur tersebut saat dijalankan, aplikasi wajib memeriksa status izin dan menampilkan dialog sistem (*system dialog prompt*) secara eksplisit.
  * Pengguna memiliki wewenang penuh untuk memilih:
    * **Allow (Izinkan)**
    * **Only this time (Hanya kali ini)** / **While using the app (Saat aplikasi digunakan)**
    * **Don't allow (Jangan izinkan)**
  * Pengguna juga dapat mencabut (*revoke*) izin ini kapan saja melalui menu Pengaturan (*Settings*) perangkat.
  * Aplikasi harus menangani skenario jika pengguna menolak izin tersebut (*fallback mechanism*).

---

### 📊 Tabel Perbandingan

| Parameter | Normal Permission (e.g. Internet) | Dangerous Permission (e.g. Camera/Location) |
| :--- | :--- | :--- |
| **Tingkat Risiko Privasi** | Sangat Rendah | Tinggi (Data Sensitif / Privasi) |
| **Runtime Prompt ke Pengguna** | **Tidak Ada** (Otomatis Diberikan) | **Ada** (Pop-up sistem interaktif wajib muncul) |
| **Waktu Pemberian Izin** | Saat Instalasi Aplikasi | Saat Fitur Digunakan (*On-Demand / Runtime*) |
| **Pencabutan Izin oleh Pengguna** | Tidak bisa dicabut secara individual | Dapat dicabut kapan saja via Settings |
| **Deklarasi Manifest** | Diperlukan di `AndroidManifest.xml` | Diperlukan di `AndroidManifest.xml` **DAN** dikodekan di Kotlin (`ActivityResultLauncher` / `checkSelfPermission`) |

---

## 🛠️ Fitur & Teknologi Proyek

* **Bahasa Pemrograman**: Kotlin
* **Networking / Internet**: Retrofit / Volley / Ktor / OkHttp
* **Parsing Data**: Gson / Kotlinx Serialization
* **UI Components**: RecyclerView, ViewBinding, SwipeRefreshLayout
* **Permissions Handling**: `AndroidManifest.xml` & Runtime Permission Checks

---

## 🚀 Cara Menjalankan Proyek

1. **Clone Repository**
   ```bash
  
   ```

2. **Buka di Android Studio**
   * Buka aplikasi **Android Studio**.
   * Pilih **Open** dan arahkan ke folder hasil clone.

3. **Sync Gradle & Run**
   * Lakukan **Sync Project with Gradle Files**.
   * Jalankan aplikasi pada emulator atau perangkat fisik Android yang terhubung dengan koneksi internet.
