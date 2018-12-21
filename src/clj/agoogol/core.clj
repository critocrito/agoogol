(ns agoogol.core
  (:require [clojure.java.io :as io]
            [clojure.string :as s]
            [org.httpkit.client :as http]
            [net.cgrand.enlive-html :as html]))

(defn make-http-call
  "Handle a single HTTP and parse inputs and outputs to and from JSON."
  [{:keys [method url] :as request}]
  (let [{:keys [error body]} @(http/request request)]
    (if error
      (throw (Exception. (str method " request to " url " failed: " error)))
      body)))

(defn google
  [term]
  (let [request {:method :get
                 :user-agent "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Mobile Safari/537.36"
                 :url "https://google.com/search"
                 :query-params {"q" term}}
        response (make-http-call request)]
    response))

(defn random-sleep
  [from till]
  (let [r (rand-int (- till from))]
    (* (+ from r) 1000)))

(defn has-results
  [text]
  (> 0 (count (html/select (html/html-resource (java.io.StringReader. text)) [:div.srg :> :div]))))

(defn writeln
  [writer elems]
  (let [line (s/join "," elems)]
    (doto writer
      (.write line)
      (.newLine)
      (.flush))))

(defn run-experiment
  [input output & {:keys [transformation min-sleep max-sleep] :or {transformation identity min-sleep 5 max-sleep 15}}]
  (with-open [reader (io/reader input)
              writer (io/writer output)]
    (do
      (writeln writer ["input" "term" "success"])
      (let [inputs (line-seq reader)]
        (doseq [input inputs]
          (let [sleep (random-sleep min-sleep max-sleep)
                term (transformation input)
                success (->> term
                             google
                             has-results)]
            (do
              (writeln writer [input term success])
              (println (str "Experiment for '" term "' was " (when-not success "un") "successful. Sleeping for " sleep " ms."))
              (Thread/sleep sleep))))))))
