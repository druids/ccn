(defproject ccn "0.1.0"
  :description "A small library for CSS class composition"
  :url "https://github.com/druids/ccn"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}

  :source-paths ["src/cljc"]

  :test-paths ["test/cljc"]

  :profiles {:dev {:plugins [[lein-cloverage "1.0.10"]
                             [lein-kibit "0.1.6"]
                             [jonase/eastwood "0.2.5"]]
                   :dependencies [[org.clojure/clojure "1.9.0"]
                                  [org.clojure/clojurescript "1.9.946"]]}
             :cljs {:plugins [[lein-cljsbuild "1.1.7"]
                              [lein-doo "0.1.8"]]
                    :doo {:build "test"}
                    :cljsbuild {:builds
                                {:test {:source-paths ["src" "test"]
                                        :compiler {:main ccn.runner
                                                   :output-to "target/test/core.js"
                                                   :optimizations :none
                                                   :source-map true
                                                   :pretty-print true
                                                   ;; workaround for running lein doo with latest CLJS, see
                                                   ;; https://github.com/bensu/doo/pull/141}}}}
                                                   :process-shim false}}}}}}

  :eastwood {:exclude-namespaces [ccn.runner]}
  :aliases {"cljs-tests" ["with-profile" "cljs" "doo" "phantom" "once"]
            "cljs-auto" ["with-profile" "cljs" "cljsbuild" "auto"]
            "cljs-once" ["with-profile" "cljs" "cljsbuild" "once"]})
