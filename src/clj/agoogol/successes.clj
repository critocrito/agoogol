(ns agoogol.successes
  (:require [net.cgrand.enlive-html :as html]))

(defn results
  [text]
  (html/select (html/html-resource (java.io.StringReader. text))
               [:div.srg :> :div]))

(defn did-you-mean
  [text]
  (html/select (html/html-resource (java.io.StringReader. text))
               [:div#taw :p.card-section :> :a :> :b :> :i]))

(defn results? [text] (empty? (results text)))
(defn did-you-mean? [text] (not (empty? (did-you-mean text))))

(defn success?
  [text]
  (or
   (results? text)
   (did-you-mean? text)))
