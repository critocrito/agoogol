;;; Experiment 5
(ns agoogol.experiments.corpus-test-pig-latin-did-you-mean
  (:require [agoogol.transformations :refer [pig-latin]]
            [agoogol.successes :refer [has-did-you-mean]]
            [agoogol.core :refer [run-experiment google]]))

(def input "./inputs/corpus-test.txt")
  (def output "./outputs/corpus-test-pig-latin-did-you-mean.csv")

(defn -main
  []
  (run-experiment input output :transformation pig-latin :success-test has-did-you-mean))
