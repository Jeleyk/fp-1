(ns ru.jeleyka.functionalprogramming.lab1.task9)

(defn is-rhs-triangle? [a b c]
  (= (+ (* a a) (* b b)) (* c c)))

(defn find-triangle-tail-rec [a b]
  (let [c (- 1000 a b)]
    (if (= (+ (* a a) (* b b)) (* c c))
      [a b c]
      (if (< b (- 1000 a))
        (recur a (inc b))
        (recur (inc a) (+ a 1))))))

(defn solve-tail-rec []
  (let [[a b c] (find-triangle-tail-rec 1 2)]
    (* a b c)))

(defn triangle-seq []
  (for [a (range 1 1001)
        b (range a (- 1001 a))]
    [a b (- 1000 a b)]))

(defn solve-lazy []
  (let [[a b c] (first (filter #(is-rhs-triangle? (first %) (second %) (last %)) (triangle-seq)))]
    (* a b c)))

(defn generate-triangles []
  (map (fn [[a b]] [a b (- 1000 a b)])
       (for [a (range 1 1001)
             b (range a (- 1001 a))]
         [a b])))

(defn solve-map-filter []
  (let [[a b c] (first (filter #(apply is-rhs-triangle? %) (generate-triangles)))]
    (* a b c)))
