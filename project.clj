(defproject tetris "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]

                 [clojure-lanterna "0.9.7"]] ;; Advanced console library for Clojure.
  :main tetris.core
  :aot :all
  :profiles {:native-image {:dependencies [[org.clojure/clojure "1.10.2-alpha2"]
                                           [borkdude/clj-reflector-graal-java11-fix "0.0.1-graalvm-20.2.0"]]}})
