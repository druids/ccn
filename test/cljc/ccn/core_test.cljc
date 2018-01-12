(ns ccn.core-test
  (:require
    #?(:clj [clojure.test :refer [are deftest testing is]])
    #?(:cljs [cljs.test :refer-macros [are deftest testing is]])
    [ccn.core :as ccn]))


(deftest bem-test

  (testing "should return a CSS class with modifiers"
    (is (= "block block--modifier1 block--modifier2"
           (ccn/bem "block" ["modifier1" "modifier2"]))))

  (testing "should return a CSS class with block, element and modifiers"
    (is (= "block__element block__element--modifier1 block__element--modifier2"
           (ccn/bem "block" "element" ["modifier1" "modifier2"]))))

  (testing "should return a CSS class without nils"
    (is (= "block" (ccn/bem "block" [nil])))))


(deftest css-class-test
  (testing "should return CSS class"
    (are [expected classes] (= expected (apply ccn/css-class classes))
         "" []
         "foo" ["foo" " "]
         "bar" ["" "bar" nil])))


(deftest twbs-test
  (testing "should compose a CSS class in Twitter Bootstrap way"
    (are [expected base modifiers] (= expected (ccn/twbs base modifiers))
         "table" "table" []
         "table table-responsive" "table" ["responsive" nil ""]
         "disabled btn btn-primary" "btn" ["primary" "disabled"])))
