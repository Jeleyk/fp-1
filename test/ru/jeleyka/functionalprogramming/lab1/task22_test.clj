(ns ru.jeleyka.functionalprogramming.lab1.task22-test
  (:require [clojure.test :refer :all]
            [ru.jeleyka.functionalprogramming.lab1.task22 :refer :all]))

(def test-file "names.txt")

(deftest test-tail-recursion
  (is (= 871198282 (solve-tail test-file))))

(deftest test-modular-solution
  (is (= 871198282 (solve test-file))))

(deftest test-lazy-solution
  (is (= 871198282 (solve-lazy test-file))))