# 🛒 Pricing Project – Shopping Cart Calculation System

## 📌 Overview

This project is a solution to a technical assignment where the goal is to model a real-world pricing system for an online product sales company.

The application calculates the total cost of a shopping cart based on:

* Product type
* Client type
* Business rules for pricing

---

## 🎯 Problem Statement

The company sells:
* High-end phones
* Mid-range phones
* Laptops

There are two types of clients:
1. **Individual Clients**
2. **Professional Clients**
Pricing varies depending on the client type and (for professionals) their annual revenue. 

---

## 🧠 Solution Approach

This project uses:
* **Strategy Design Pattern** → for flexible pricing logic
* **Factory Pattern** → to select the correct pricing strategy
* **Clean Object-Oriented Design**

### Key Idea:

Each client type has its own pricing strategy, making the system:
* Extensible
* Maintainable
* Easy to test

---

## 🏗️ Project Structure
src/main/java/org/example
│
├── cart                → ShoppingCart logic
├── client              → Client models (Individual, Professional)
├── PricingStrategy     → Strategy + Factory
├── exception           → Custom exceptions
└── Main                → Entry point (if used)

## 💰 Pricing Rules

### 👤 Individual Client
* High-end phone → €1500
* Mid-range phone → €800
* Laptop → €1200

### 🏢 Professional Client
#### Revenue > €10M (Major Client)
* High-end phone → €1000
* Mid-range phone → €550
* Laptop → €900
#### Revenue ≤ €10M (Small Client)
* High-end phone → €1150
* Mid-range phone → €600
* Laptop → €1000

---

## ⚙️ How It Works

1. A `Client` is created (Individual or Professional)
2. A `ShoppingCart` is initialized with the client
3. Products are added with quantities
4. `PricingStrategyFactory` selects the correct pricing strategy
5. Total is calculated using that strategy

---

## 🧪 Unit Tests
The project includes comprehensive JUnit tests covering:
* Individual pricing
* Professional pricing (major & small)
* Edge cases (empty cart, invalid quantity)
* Factory behavior

Example:
```java
ShoppingCart cart = new ShoppingCart(client);
cart.addProduct(Product.HIGH_END_PHONE, 1);
double total = cart.calculateTotal();
```

---

## ▶️ How to Run the Project
### ✅ Prerequisites
* Java 17+
* Maven
### 🔹 Run Tests (Recommended)

```bash
mvn clean test
```

## 🚀 Key Design Highlights
* ✔ Uses **Strategy Pattern** for pricing flexibility
* ✔ Uses **Factory Pattern** for clean object creation
* ✔ Uses **Java Records & Sealed Interfaces** for modern design
* ✔ Fully **unit tested**
* ✔ Handles invalid inputs via custom exceptions

---

## ❗ Assumptions
* No UI required (as per assignment)
* Data is in-memory
* Prices are fixed and predefined

---

## 👩‍💻 Author
**Ayushi Shukla**

---
