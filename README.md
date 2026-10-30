# ARBuz CHEAT Beta 1.2 — Android companion UI

## Included
- Black/red login screen with key format validation (`ArbuzShop` + 10 digits).
- Server-verification client scaffold (HTTPS endpoint placeholder).
- Dashboard shown only after a successful server response.
- Android floating utility panel using the system overlay permission.
- ESP/HUD, Aim Trainer and Farm Demo information screens.
- Android project suitable for opening in Android Studio or a compatible on-device IDE.

## Build
1. Extract the ZIP.
2. Open the project folder in Android Studio / compatible Android IDE.
3. Configure the HTTPS verification URL in `MainActivity.java`.
4. Deploy a backend matching `server-contract/README.md`.
5. Sync Gradle and build the debug APK.

APK output: `app/build/outputs/apk/debug/app-debug.apk`

## Virtual Master
Install the APK inside the Virtual Master environment if that environment supports ordinary Android APK installation and overlay permission. Grant the overlay permission from the in-app button / Android settings. Virtual Master may impose its own restrictions on overlays; this project cannot override those restrictions.

## Important scope
This is a standalone companion app. It does not inject into Oxide, read game memory, reveal players or bases through walls, automate aiming/farming, or bypass anti-cheat. The floating panel is a generic app overlay only.

## Server status
No backend is included or deployed. Server authentication will not succeed until you configure and deploy your own HTTPS API. The lifetime key mentioned in chat is not automatically registered or activated.
