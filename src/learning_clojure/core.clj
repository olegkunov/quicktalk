
(ns learning-clojure.core
  (:gen-class))

(def script {:steps 3
             {:id 1} {:action :get-string :var :s}
             {:id 2} {:action '(println "!")}
             {:id 3} {:action :get-number :var :n}})

(defmulti get-answer identity)
(defmethod get-answer :string [_] "a string")
(defmethod get-answer :number [_] 10)

(defn process-step [step]
  (let [answer (case (:action step)
    :get-string (get-answer :string)
    :get-number (get-answer :number)
    (eval (:action step)))]
    (println "got" answer "into" (:var step))))

(defn go [] (map (fn [i] (process-step (script {:id i}))) (range 1 (inc (:steps script)))))

