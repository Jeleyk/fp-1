(ns ru.jeleyka.functionalprogramming.lab1.task22
  (:use [clojure.string :only [split]]))

(defn get-data [fname]
  (sort (split (slurp fname) #",")))

(defn name-score-tail [idx nm acc]
  (if (empty? nm)
    (* idx acc)
    (let [char-val (- (int (first nm)) 64)]
      (recur idx (rest nm) (+ acc char-val)))))

(defn solve-tail [fname]
  (let [data (sort (map #(clojure.string/replace % "\"" "") (split (slurp fname) #",")))]
    (loop [idx 1 names data total 0]
      (if (empty? names)
        total
        (recur (inc idx) (rest names) (+ total (name-score-tail idx (first names) 0)))))))

(defn name-score [idx nm]
  (->> nm
       (remove #(= % \"))
       (map #(- (int %) 64))
       (reduce +)
       (* idx)))

(defn solve [fname]
  (reduce +
          (map name-score (iterate inc 1) (get-data fname))))

(defn infinite-names [fname]
  (let [data (sort (split (slurp fname) #","))]
    (map #(name-score %1 %2) (iterate inc 1) data)))

(defn solve-lazy [fname]
  (reduce + (infinite-names fname)))
