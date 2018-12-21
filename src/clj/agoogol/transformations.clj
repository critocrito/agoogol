(ns agoogol.transformations)

(defn pig-latin [word]
  (let [first-letter (first word)]
    (if ((set "aeiou") first-letter)
      (str word "ay")
      (str (subs word 1) first-letter "ay"))))
