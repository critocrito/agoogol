;;; Experiment 2
(ns agoogol.experiments.corpus-test
  (:require [agoogol.core :refer [run-experiment google]]))

(def input "./inputs/corpus-test.txt")
(def output "./outputs/corpus-test.csv")

(defn -main
  []
  (run-experiment input output))
