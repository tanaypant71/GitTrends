# GitTrends

GitTrends is an Android application that allows you to explore and discover trending GitHub repositories. It fetches data from the GitHub API and displays the repositories in a user-friendly interface.

## Features

- **Trending Repositories**: View a list of GitHub repositories that are currently trending.
- **Repository Details**: Click on a repository to view its details, such as the number of stars, the owner, and a description.
- **Open on GitHub**: Easily open any repository on the GitHub website for more details.
- **Modern Architecture**: The project follows a clean and modern Android architecture.

## Major Components

### 1. Retrofit and GitHub API Integration

Retrofit is used to make network requests to the GitHub API. The [GitHub API](https://docs.github.com/en/rest) provides access to a wide range of GitHub data, including repositories, users, and more.

### 2. View Binding

The project leverages View Binding to simplify the interaction between layouts and activities or fragments. It helps to avoid null pointer exceptions and streamlines the UI code.

### 3. RecyclerView and Adapters

The RecyclerView is used to display the list of GitHub repositories. The custom `RepoAdapter` class is responsible for managing the data and creating the views for each repository.

### 4. Coroutines

Kotlin Coroutines are employed for managing asynchronous tasks, especially for network requests. The app ensures a smooth and responsive user experience.

### 5. Android Architecture

This app follows a MVP architecture.

### 6. APK File

https://drive.google.com/file/d/11CMYSv0PuDUEqvgIbTN0vUw7wzWeD5bx/view?usp=drive_link




https://github.com/tanaypant71/GitTrends/assets/80039257/b331787e-ca5f-4d6e-9aa7-50ee4cfa46b9



https://github.com/tanaypant71/GitTrends/assets/80039257/743c1df5-688c-4f56-ab9c-f875c40d90b4




## Acknowledgments

- This project makes use of the [Retrofit](https://square.github.io/retrofit/) library for making network requests.
- [Glide](https://bumptech.github.io/glide/) is used for image loading.
- The GitHub API provides the data for this project.

