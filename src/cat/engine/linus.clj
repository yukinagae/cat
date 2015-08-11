(ns cat.engine.linus
  (:require [net.cgrand.enlive-html :as html]))

(def linus "Linus Torvalds")

;; TODO this is buggy. should avoid "External Links"
;; TODO should include a tag within li tag
(defn quotes []
  (-> (java.net.URL. "https://en.wikiquote.org/wiki/Linus_Torvalds") 
    html/html-resource 
    (html/select [:div#mw-content-text :> :ul :> :li])))

(defn get-quote [quotes]
  (let [r (rand-int (count quotes))]
    (-> (nth quotes r) :content first)))

(defn add-author [q]
  (str q " ― " linus))

;; "Talk is cheap. Show me the code. ― Linus Torvalds"
(defn response [] (-> (quotes) get-quote add-author))
