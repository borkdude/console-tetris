# console-tetris

## GraalVM

This is a fork of [netb258/console-tetris](https://github.com/netb258/console-tetris) to see if this can be compiled with GraalVM native-image.

To compile, set `$GRAALVM_HOME` to GraalVM 20.2.0 JDK11.
Also install [lein](https://github.com/technomancy/leiningen).

Then run `script/compile`.

This will produce a binary called `tetris`.

The change that was necessary to make this work: change terminal to `:text`
instead of `:swing` since Swing is not supported by GraalVM `native-image`.



## README from original

A command line implementation of Tetris, written in Clojure.

Uses clojure-lanterna for rendering.

![Alt text](./screenshot_1.png?raw=true "Title")

# Usage


    $ lein run

# Running in system shell

By default the program is set to run in a swing based console (for portability).

If you want to run it in the OS shell, then you will need to change src/tetris/gui.clj slightly.

Notice that line 12 of gui.clj sets the WINDOW var with the :swing keyword.

Just change that keyword to :unix if you are on a Unix OS.

Under MS Windows only :cygwin is supported, so you will need to install Cygwin.

In addition, you will also need to remove lines 164 and 165 of src/tetris/core.clj.

## License

Copyright © 2019 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
