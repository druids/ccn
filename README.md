CCN (Compose Class Name)
========================

A small library for CSS class composition, it supports both Clojure and ClojureScript.

[![CircleCI](https://circleci.com/gh/druids/ccn.svg?style=svg)](https://circleci.com/gh/druids/ccn)
[![Dependencies Status](https://jarkeeper.com/druids/ccn/status.png)](https://jarkeeper.com/druids/ccn)
[![License](https://img.shields.io/badge/MIT-Clause-blue.svg)](https://opensource.org/licenses/MIT)


Leiningen/Boot
--------------

```clojure
[ccn "0.0.0"]
```

Documentation
-------------

```clojure
(require '[ccn.core :as ccn])
```


### bem
Composes a CSS class for an element with modifiers by BEM methodology.

```clojure
(ccn/bem "block" ["modifier1" "modifier2"])
"block block--modifier1 block--modifier2"

(ccn/bem "block" "element" ["modifier1" "modifier2"])
"block__element block__element--modifier1 block__element--modifier2"

(ccn/bem "block" [nil])
"block"
```


### css-class
Composes a CSS class from given args, removes blanks.

```clojure
(ccn/css-class "foo" nil "")
"foo"

(ccn/css-class "foo" "bar")
"foo bar"
```


### twbs
Composes a CSS class in Twitter Bootstrap way. It handles special cases like `disabled`.

```clojure
(ccn/twbs "table" ["responsive" nil ""])
"table table-responsive"

(ccn/twbs "btn" ["primary" "disabled"])
"disabled btn btn-primary"
```
