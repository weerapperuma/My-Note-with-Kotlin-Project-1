# My Note

My Note is an Android note-taking app built with Kotlin and Jetpack Compose. The project is structured as a clean, layered Android codebase so it can grow from a learning project into a production-style app.

## Current Status

This project has a good industry-style foundation, but it is not production-complete yet. The package structure already separates data, domain, presentation, navigation, and dependency-injection concerns, which is the right direction for a maintainable Android app. Several files are still placeholders and need implementation before the app is ready for real users.

## Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- AndroidX Lifecycle
- Room
- KSP
- Gradle Version Catalog
- Android Gradle Plugin 9.x with built-in Kotlin support

## Project Structure

```text
app/src/main/java/lk/zeylanix/mynote/
+-- data/
|   +-- local/          # Room database, DAO, and entities
|   +-- mapper/         # Data/domain mapping
|   +-- repository/     # Repository implementations
+-- di/                 # Dependency injection modules
+-- domain/
|   +-- model/          # Business models
|   +-- repository/     # Repository contracts
|   +-- usecase/        # Application use cases
+-- navigation/         # App navigation
+-- presentation/
|   +-- noteeditor/     # Note editor UI and state
|   +-- notelist/       # Note list UI and state
+-- ui/theme/           # Compose theme setup
+-- MainActivity.kt
+-- NotesApp.kt
```

## Architecture

The project follows a lightweight clean architecture approach:

- `domain` contains app business rules and does not depend on Android framework classes.
- `data` contains persistence and repository implementations.
- `presentation` contains Compose screens, UI state, and ViewModels.
- `navigation` owns screen routes and graph setup.
- `di` is reserved for dependency wiring.

This structure is suitable for an industry project once the placeholder classes are implemented and test coverage is added.

## Gradle Notes

This project uses Android Gradle Plugin 9.x. AGP 9 has built-in Kotlin support, so the project should not apply `org.jetbrains.kotlin.android` manually.

KSP dependencies are added with:

```kotlin
add("ksp", libs.androidx.room.compiler)
```

This avoids Kotlin DSL accessor issues in Android Studio while still using the KSP configuration.

## Getting Started

### Requirements

- Android Studio with JDK 21 support
- Android SDK 36.1 installed
- Gradle wrapper included in the project

### Build

On Windows:

```powershell
.\gradlew.bat :app:assembleDebug
```

On macOS or Linux:

```bash
./gradlew :app:assembleDebug
```

### Run Tests

```powershell
.\gradlew.bat test
```

## Production Readiness Checklist

The current structure is good, but these items should be completed before treating it as an industry-ready app:

- Implement `NoteDao`, `NoteDatabase`, and `NoteRepositoryImpl`.
- Connect ViewModels to use cases and repositories.
- Replace the default `Greeting` screen in `MainActivity`.
- Implement the navigation graph and actual note list/editor screens.
- Add dependency injection using Hilt or manual DI.
- Add unit tests for use cases, repositories, and ViewModels.
- Add Room migration strategy before changing database versions.
- Add UI tests for core note flows.
- Add release signing, minification rules, and build variants if needed.
- Add CI checks for build, tests, and lint.

## Recommended Next Milestones

1. Complete Room persistence.
2. Wire repository and use cases.
3. Build the note list screen.
4. Build the note editor screen.
5. Add navigation between list and editor.
6. Add tests for save, load, and delete note flows.

## Package Naming

The app package is:

```text
lk.zeylanix.mynote
```

Keep new files inside this package unless there is a clear reason to introduce another module or namespace.

## License

No license has been selected yet.
