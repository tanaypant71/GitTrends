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

While the code does not strictly adhere to a specific architecture pattern, it follows best practices to keep UI and data logic separate, promoting maintainability.

## Installation

1. Clone the repository to your local machine using `git clone`.
2. Open the project in Android Studio.
3. Build and run the application on an Android emulator or device.

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests to enhance the project.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.




https://github.com/tanaypant71/GitTrends/assets/80039257/ef06a413-4742-4c17-bf66-9140ab19381b



https://github.com/tanaypant71/GitTrends/assets/80039257/7805e2d0-33a1-479f-a6f7-d4f173285971

![Screenshot_20231030-132515_GitTrends](https://github.com/tanaypant71/GitTrends/assets/80039257/4b568fdc-e40f-40fe-b935-d6bea24eeb17)
![Screenshot_20231030-132454_GitTrends](https://github.com/tanaypant71/GitTrends/assets/80039257/073d639f-9b3f-4082-a137-f74ee9277726)
![Screenshot_20231030-132447_GitTrends](https://github.com/tanaypant71/GitTrends/assets/80039257/cd610ee4-f364-4bb2-b941-fe1198ebbbed)


## Acknowledgments

- This project makes use of the [Retrofit](https://square.github.io/retrofit/) library for making network requests.
- [Glide](https://bumptech.github.io/glide/) is used for image loading.
- The GitHub API provides the data for this project.

