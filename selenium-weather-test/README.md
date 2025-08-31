# 🌦️ Selenium Weather Test

Dự án test automation dùng **Java + Selenium + JUnit 5** để kiểm tra chức năng tìm kiếm thời tiết theo thành phố trên trang OpenWeather.

---

## 🚀 Công nghệ sử dụng
- **Java 17**
- **Maven 3.9+**
- **Selenium 4.23.0**
- **JUnit 5**


---

## 📂 Cấu trúc project
selenium-weather-test
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── pages
│   │           ├── BasePage.java
│   │           ├── HomePage.java
│   │           └── SearchResultPage.java
│   └── test
│       └── java
│           └── tests
│               └── WeatherTest.java
└── README.md

---

## 🧪 Kịch bản kiểm thử chính
1. Mở trang `https://openweathermap.org/`
2. Tìm kiếm thành phố: `"Los Angeles, US"`
3. Xác minh:
    - **Tên thành phố** hiển thị chứa "Los Angeles"
    - **Thời gian hiện tại** theo múi giờ Los Angeles, định dạng `MMM dd, hh:mma` (ví dụ: `Jan 05, 07:25PM`)
    - **Nhiệt độ** có chứa số (ví dụ: `15°C`)

Các thao tác được đóng gói trong Page Object:
- `HomePage.searchCity(...)`
- `SearchResultPage.verifyCity(...)`
- `SearchResultPage.verifyCurrentTime()`
- `SearchResultPage.verifyTemperature()`

---
