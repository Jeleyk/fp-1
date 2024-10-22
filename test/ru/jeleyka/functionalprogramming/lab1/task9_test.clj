(ns ru.jeleyka.functionalprogramming.lab1.task9-test
  (:require [clojure.test :refer :all]
            [ru.jeleyka.functionalprogramming.lab1.task9 :refer :all]))

(def expected-result 31875000)

(deftest test-solve-tail-rec
  (is (= expected-result (solve-tail-rec))))

(deftest test-solve-lazy
  (is (= expected-result (solve-lazy))))

(deftest test-solve-map-filter
  (is (= expected-result (solve-map-filter))))