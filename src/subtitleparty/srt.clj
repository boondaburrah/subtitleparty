(ns subtitleparty.srt
  (:require [clojure.string :as string]))

(defn parse-time "Parse a time line and return a list of two times" [time-string]
  (map string/trim (string/split time-string #"-->")))