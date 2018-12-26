;;; Experiment 4
(ns agoogol.experiments.corpus-test-did-you-mean
  (:require [agoogol.successes :refer [has-did-you-mean]]
            [agoogol.core :refer [run-experiment google]]))

(def input "./inputs/corpus-test.txt")
(def output "./outputs/corpus-test-did-you-mean.csv")

(defn -main
  []
  (run-experiment input output :success-test has-did-you-mean))
