# console-tetris

## GraalVM

This is a fork of [netb258/console-tetris](https://github.com/netb258/console-tetris) to see if this can be compiled with GraalVM native-image.

To compile, set `$GRAALVM_HOME` to GraalVM 20.2.0 JDK11.
Also install [lein](https://github.com/technomancy/leiningen).

Then run `script/compile`.

Currently the compilation fails in the link step with:

```
Fatal error:java.lang.RuntimeException: java.lang.RuntimeException: There was an error linking the native image: Linker command exited with 1

Linker command executed:
/usr/bin/cc -Wl,-no_compact_unwind -Wl,-exported_symbols_list -Wl,/var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126/exported_symbols.list -Wl,-x -arch x86_64 -o /private/tmp/console-tetris/tetris /var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126/tetris.o /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/liblibchelper.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libnet.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libffi.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libdarwin.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libnio.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libjava.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libfdlibm.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libsunec.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libzip.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libjvm.a -v -L/var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126 -L/Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib -L/Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64 -lstdc++ -Wl,-framework,CoreServices -Wl,-framework,Foundation -lpthread -ldl -lz

Linker command output:
Apple clang version 11.0.0 (clang-1100.0.33.12)
Target: x86_64-apple-darwin18.7.0
Thread model: posix
InstalledDir: /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin
 "/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/ld" -demangle -lto_library /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/libLTO.dylib -dynamic -arch x86_64 -macosx_version_min 10.14.0 -syslibroot /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk -o /private/tmp/console-tetris/tetris -L/var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126 -L/Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib -L/Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64 -no_compact_unwind -exported_symbols_list /var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126/exported_symbols.list -x /var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126/tetris.o /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/liblibchelper.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libnet.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libffi.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libdarwin.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libnio.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libjava.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libfdlibm.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libsunec.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libzip.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libjvm.a -lc++ -framework CoreServices -framework Foundation -lpthread -ldl -lz -L/usr/local/lib -lSystem /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/clang/11.0.0/lib/darwin/libclang_rt.osx.a
Undefined symbols for architecture x86_64:
  "_Java_java_util_prefs_MacOSXPreferencesFile_addChildToNode", referenced from:
      ___svm_vm_target_libc in tetris.o
  "_Java_java_util_prefs_MacOSXPreferencesFile_addNode", referenced from:
      ___svm_cglobaldata_base in tetris.o
  "_Java_java_util_prefs_MacOSXPreferencesFile_getChildrenForNode", referenced from:
      ___svm_vm_target_libc in tetris.o
  "_Java_java_util_prefs_MacOSXPreferencesFile_getKeyFromNode", referenced from:
      ___svm_vm_target_libc in tetris.o
  "_Java_java_util_prefs_MacOSXPreferencesFile_synchronize", referenced from:
      ___svm_version_info in tetris.o
ld: symbol(s) not found for architecture x86_64
clang: error: linker command failed with exit code 1 (use -v to see invocation)

	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at java.util.concurrent.ForkJoinTask.getThrowableException(ForkJoinTask.java:593)
	at java.util.concurrent.ForkJoinTask.get(ForkJoinTask.java:1005)
	at com.oracle.svm.hosted.NativeImageGenerator.run(NativeImageGenerator.java:480)
	at com.oracle.svm.hosted.NativeImageGeneratorRunner.buildImage(NativeImageGeneratorRunner.java:349)
	at com.oracle.svm.hosted.NativeImageGeneratorRunner.build(NativeImageGeneratorRunner.java:508)
	at com.oracle.svm.hosted.NativeImageGeneratorRunner.main(NativeImageGeneratorRunner.java:114)
Caused by: java.lang.RuntimeException: There was an error linking the native image: Linker command exited with 1

Linker command executed:
/usr/bin/cc -Wl,-no_compact_unwind -Wl,-exported_symbols_list -Wl,/var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126/exported_symbols.list -Wl,-x -arch x86_64 -o /private/tmp/console-tetris/tetris /var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126/tetris.o /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/liblibchelper.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libnet.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libffi.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libdarwin.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libnio.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libjava.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libfdlibm.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libsunec.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libzip.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libjvm.a -v -L/var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126 -L/Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib -L/Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64 -lstdc++ -Wl,-framework,CoreServices -Wl,-framework,Foundation -lpthread -ldl -lz

Linker command output:
Apple clang version 11.0.0 (clang-1100.0.33.12)
Target: x86_64-apple-darwin18.7.0
Thread model: posix
InstalledDir: /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin
 "/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/ld" -demangle -lto_library /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/libLTO.dylib -dynamic -arch x86_64 -macosx_version_min 10.14.0 -syslibroot /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk -o /private/tmp/console-tetris/tetris -L/var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126 -L/Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib -L/Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64 -no_compact_unwind -exported_symbols_list /var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126/exported_symbols.list -x /var/folders/2m/h3cvrr1x4296p315vbk7m32c0000gp/T/SVM-3456295400881317126/tetris.o /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/liblibchelper.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libnet.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libffi.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libdarwin.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libnio.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libjava.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libfdlibm.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libsunec.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/libzip.a /Users/borkdude/Downloads/graalvm-ce-java8-20.2.0/Contents/Home/jre/lib/svm/clibraries/darwin-amd64/libjvm.a -lc++ -framework CoreServices -framework Foundation -lpthread -ldl -lz -L/usr/local/lib -lSystem /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/clang/11.0.0/lib/darwin/libclang_rt.osx.a
Undefined symbols for architecture x86_64:
  "_Java_java_util_prefs_MacOSXPreferencesFile_addChildToNode", referenced from:
      ___svm_vm_target_libc in tetris.o
  "_Java_java_util_prefs_MacOSXPreferencesFile_addNode", referenced from:
      ___svm_cglobaldata_base in tetris.o
  "_Java_java_util_prefs_MacOSXPreferencesFile_getChildrenForNode", referenced from:
      ___svm_vm_target_libc in tetris.o
  "_Java_java_util_prefs_MacOSXPreferencesFile_getKeyFromNode", referenced from:
      ___svm_vm_target_libc in tetris.o
  "_Java_java_util_prefs_MacOSXPreferencesFile_synchronize", referenced from:
      ___svm_version_info in tetris.o
ld: symbol(s) not found for architecture x86_64
clang: error: linker command failed with exit code 1 (use -v to see invocation)

	at com.oracle.svm.hosted.image.NativeBootImageViaCC.handleLinkerFailure(NativeBootImageViaCC.java:459)
	at com.oracle.svm.hosted.image.NativeBootImageViaCC.write(NativeBootImageViaCC.java:434)
	at com.oracle.svm.hosted.NativeImageGenerator.doRun(NativeImageGenerator.java:677)
	at com.oracle.svm.hosted.NativeImageGenerator.lambda$run$0(NativeImageGenerator.java:468)
	at java.util.concurrent.ForkJoinTask$AdaptedRunnableAction.exec(ForkJoinTask.java:1386)
	at java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:289)
	at java.util.concurrent.ForkJoinPool$WorkQueue.runTask(ForkJoinPool.java:1056)
	at java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1692)
	at java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:163)
Error: Image build request failed with exit status 1
com.oracle.svm.driver.NativeImage$NativeImageError: Image build request failed with exit status 1
	at com.oracle.svm.driver.NativeImage.showError(NativeImage.java:1558)
	at com.oracle.svm.driver.NativeImage.build(NativeImage.java:1308)
	at com.oracle.svm.driver.NativeImage.performBuild(NativeImage.java:1269)
	at com.oracle.svm.driver.NativeImage.main(NativeImage.java:1228)
```

Created an [issue](https://github.com/oracle/graal/issues/2898) about it.

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
