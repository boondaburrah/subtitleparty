(ns subtitleparty.srt-test
  (:require [clojure.test :refer :all]
            [subtitleparty.srt :refer :all]))

(deftest test-srt
  (testing "parse time line"
    (is (= (parse-time "00:00:15,000 --> 00:00:18,000") '("00:00:15,000" "00:00:18,000")))))