# Android Dynamic Class Loader Example

A quick example of dynamically loading classes.

## Quickstart

Before building the project, run the following:

```bash
bash build_dex.sh
```

This builds `Hello.java` into `classes.dex` and copies the dex to the raw resources folder.

You can then run the project in an emulator or on your phone and should see
"Hello InMemoryDexClassLoader!" in the home fragment.
