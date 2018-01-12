(ns ccn.runner
  (:require
    [doo.runner :refer-macros [doo-tests]]
    [ccn.core-test]))


(doo-tests
  'ccn.core-test)
