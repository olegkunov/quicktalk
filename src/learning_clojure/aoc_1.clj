(ns learning-clojure.aoc_1
  (:gen-class
    :methods [[hello [] String]]
    :init init)
  (:require [clojure.java.io :as io]))

(defn -init [] [[] (ref 100)])

(defn -hello [] "Hello world")

(defn aoc_1
  []
  (with-open [s (io/input-stream "resources/input1.txt")]
    (let [sq (take-while pos? (repeatedly #(.read s)))
          corr {(int \() +1 (int \)) -1}
          result (map #(get corr %) sq)
          sum (reduce + result)
          pos (->> result (reductions +) (take-while #(>= % 0)) count inc)]
      (println sum pos))))

;(loop [c (.read s) sum 0 gone {:no 0}]
;  (if (not= c -1)
;    (recur (.read s)
;           (if (= c 40) (inc sum) (dec sum))
;           (let [yes_n (:yes gone) no_n (:no gone)]
;             (if yes_n gone (if (neg? sum) {:yes no_n} {:no (inc no_n)}))))
;    (println sum (:yes gone))))))
