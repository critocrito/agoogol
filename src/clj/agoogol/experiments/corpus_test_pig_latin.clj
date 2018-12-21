;;; Experiment 3
(ns agoogol.experiments.corpus-test-pig-latin
  (:require [agoogol.transformations :refer [pig-latin]]
            [agoogol.core :refer [run-experiment google]]))

(def input "./inputs/corpus-test.txt")
(def output "./outputs/corpus-test-pig-latin.csv")

(defn -main
  []
  (run-experiment input output :transformation pig-latin))
