(ns subtitleparty.srt
  (:require [clojure.string :as string]
            [instaparse.core :as insta]))

(def parse-srt
  (insta/parser
    "srtfile = subtitle+
     subtitle = id <#'\n'> times <#'\n'> title
     id = #'\\d+' <#'.*'>
     times = time <tsep> time <#'.*'>
     <tsep> = ' --> '
     time = #'\\d\\d:\\d\\d:\\d\\d[,\\.]\\d\\d\\d'
     title = #'(?s)(.+?)(\n\\s*\n|\\Z)'
    "))

