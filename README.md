# RC Car Controller

_This is just a very simple RC Car controller which implement this [virtual joystick android Library](https://github.com/controlwear/virtual-joystick-android)._

![Alt text](/rc-car-controller.png?raw=true "RC Car controller")

## Code

#### Gradle file
Add library to dependencies.

```
dependencies {
    ...
    compile 'io.github.controlwear:virtualjoystick:1.3.0'
}
```

#### Manifest
Force activity to landscape.
```xml
<activity
    android:name=".MainActivity"
    android:screenOrientation="landscape">
    ...
```

### And that's it.
The (quick) documentation of the library is [here](https://github.com/controlwear/virtual-joystick-android).
