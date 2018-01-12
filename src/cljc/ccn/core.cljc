(ns ccn.core
  (:require
    [clojure.string :refer [blank? join]]))


(defn bem
  "Composes a CSS class for an element with modifiers by BEM methodology."
  ([block modifiers]
   (bem block nil modifiers))
  ([block element modifiers]
   (let [full-name (if (some? element)
                     (str block "__" element)
                     block)]
     (join " " (remove blank? (concat [full-name]
                                      (->> modifiers
                                           (remove blank?)
                                           (map #(str full-name "--" %)))))))))


(defn css-class
  "Composes a CSS class from given args, removes blanks."
  [& classes]
  (->> classes
       (remove blank?)
       (join " ")))


(defn twbs
  "Composes a CSS class in Twitter Bootstrap way. It handles special cases like `disabled`."
  [base modifiers]
  (let [[head tail] (split-with (partial not= "disabled") (set modifiers))]
    (->> (->> tail rest (concat head) (remove blank?) (map #(str base "-" %)))
         (concat [(first tail) base])
         (remove blank?)
         (join " "))))
