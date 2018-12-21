;;; Experiment 1
(ns agoogol.experiments.alphabet
  (:require [agoogol.core :refer [run-experiment google]]))

(def input "./inputs/alphabet.txt")
(def output "./outputs/alphabet.csv")

(defn -main
  []
  (run-experiment input output))
