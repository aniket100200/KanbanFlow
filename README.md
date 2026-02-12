# 📋 KanbanFlow - Agile Project Management Tool

![Java](https://img.shields.io/badge/Backend-Spring%20Boot-green)
![React](https://img.shields.io/badge/Frontend-Next.js-blue)
![RealTime](https://img.shields.io/badge/RealTime-WebSockets-red)
![State](https://img.shields.io/badge/State-Redux-purple)

> A modern, real-time collaborative task management platform designed for Agile teams to visualize workflows and boost productivity.

---

## 📸 Interface Snapshot

<p align="center">
  <img src="images/kanbanflow.png" alt="Kanban Board Interface" width="800">
</p>

---

## 📖 Overview

**KanbanFlow** is a full-stack clone of tools like Trello/Jira, built to demonstrate complex state management and real-time data synchronization. 

Unlike standard CRUD applications, KanbanFlow uses **WebSockets** to push updates instantly. When one user moves a card from "To Do" to "Done," all other connected team members see the movement happen live without refreshing the page.

### 🌟 Key Features

* **⚡️ Real-Time Sync:** Instant updates across all clients using **Spring Boot WebSockets (STOMP)**.
* **🖱️ Drag & Drop Interface:** Smooth, intuitive task management powered by **dnd-kit** (React).
* **🔐 Secure Auth:** JWT-based authentication with protected routes and session management.
* **🏷️ Smart Labeling:** Categorize tasks with custom color-coded tags (Bug, Feature, Urgent).
* **👥 Team Collaboration:** Assign tasks to specific users with avatar indicators.
* **📊 Sprint Analytics:** Visual charts tracking task completion rates and team velocity.

---

## 🛠️ Tech Stack

### Backend Infrastructure
* **Core:** Java Spring Boot 3.x
* **Real-Time:** Spring WebSocket (STOMP protocol)
* **Database:** MySQL 8.0
* **Security:** Spring Security & JWT
* **ORM:** Hibernate / Spring Data JPA
* **Testing:** JUnit 5 & Mockito

### Frontend Application
* **Framework:** Next.js 14 (App Router)
* **State Management:** Redux Toolkit (RTK)
* **Styling:** Tailwind CSS & Shadcn UI
* **Drag & Drop:** @dnd-kit/core
* **HTTP Client:** Axios (with interceptors)

---

## 🚀 Getting Started

Follow these steps to deploy the application locally.

### Prerequisites
* JDK 17+
* Node.js v18+
* MySQL Server running on port 3306

### 1. Backend Setup

```bash
# Clone the repository
git clone [https://github.com/yourusername/kanbanflow.git](https://github.com/yourusername/kanbanflow.git)

# Navigate to backend
cd backend

# Configure Database
# Edit src/main/resources/application.properties
# spring.datasource.url=jdbc:mysql://localhost:3306/kanban_db
# spring.datasource.username=root
# spring.datasource.password=your_password

# Run the Spring Boot Server
./mvnw spring-boot:run
