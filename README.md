# A8_231A290127 - Bản tin VHU (Giao diện modular với Fragment)

**Thông tin sinh viên:**
- Họ và tên: Bùi Quang Duy
- MSSV: 231A290127
- Môn học: Lập trình trên các thiết bị di động (Lab A8)
- Trường: Đại học Văn Hiến

## 🚀 Tiến độ hoàn thành

### Phần Cơ bản
- [x] Tạo khung chứa `FragmentContainerView` và thanh điều hướng `BottomNavigationView` với 3 tab.
- [x] Quản lý vòng đời Fragment chuẩn xác (ánh xạ View tại `onViewCreated`).
- [x] Truyền dữ liệu vào Fragment an toàn thông qua mẫu `newInstance` và `Bundle arguments`.
- [x] Xử lý Back Stack (tab không lưu vào back stack, màn hình chi tiết có lưu).
- [x] Giao tiếp giữa 2 Fragment bằng `Fragment Result API` (cập nhật trạng thái "Đánh dấu đã đọc").
- [x] Xử lý xoay màn hình không bị nạp chồng Fragment (kiểm tra `savedInstanceState == null`).

### 🌟 Phần Nâng cao (Đã hoàn thành 2 bài)
- [x] **NC1 (Bố cục master-detail cho tablet):** Tạo riêng layout `sw600dp`. Khi mở trên máy tính bảng, giao diện tự động chia làm 2 cột: danh sách tin (bên trái) và chi tiết tin (bên phải). Trên điện thoại vẫn giữ giao diện nạp chồng tiêu chuẩn.
- [x] **NC4 (Thêm hiệu ứng chuyển Fragment):** Sử dụng `setCustomAnimations()` để tích hợp hiệu ứng trượt màn hình (slide in / slide out) mượt mà mỗi khi chuyển tab hoặc mở xem chi tiết một tin tức.

## 🛠 Môi trường phát triển
- Ngôn ngữ: Java + XML
- IDE: Android Studio
- Minimum SDK: API 24
