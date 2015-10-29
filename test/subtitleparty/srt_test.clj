(ns subtitleparty.srt-test
  (:require [clojure.test :refer :all]
            [subtitleparty.srt :refer :all]))

(def testsrt "1\n00:00:01,478 --> 00:00:04,020\nVimeoSrtPlayer Example\n\n2\n00:00:05,045 --> 00:00:09,545\nSupport for <i>italic</i> font\n\n3\n00:00:09,378 --> 00:00:13,745\nSupport for <b>bold</b> font\n\n4\n00:00:14,812 --> 00:00:16,144\nMulti\nLine\nSupport ;)\n\n5\n00:00:18,211 --> 00:00:21,211\nFonts: DejaVu\nhttp://dejavu-fonts.org\n\n6\n00:00:22,278 --> 00:00:25,678 \nDejavu Sans\n\n7\n00:00:26,478 --> 00:00:31,079\n<b>DejaVu Sans Condensed Bold</b>\n\n8\n00:00:32,144 --> 00:00:38,178\n<i>DejaVu Sans Oblique</i>\n \n9\n00:00:39,812 --> 00:00:45,745\n[de.derhess.video.vimeo]\nhttp://blog.derhess.de\n\n10\n00:00:46,812 --> 00:00:52,745\n[nl.inlet42.data.subtitles]\nhttp://blog.base42.nl\n\n11\n00:00:53,812 --> 00:00:59,745\n[[ VimeoSrtPlayer ]]\nhttp://mindpirates.org\n\n12\n00:01:01,812 --> 00:01:05,745\nVideo by Kevin Klein\nhttp://vimeo.com/user4167888\n\n13\n00:01:06,812 --> 00:01:13,745\ndedicated to\nhttp://problema-thefilm.org\n\n14\n00:01:11,812 --> 00:01:15,745\nEND OF EXAMPLE FILE")

(deftest test-srt
  (testing "parse srt with instaparse"
    (is (= (parse-srt testsrt)
           [:srtfile
            [:subtitle
             [:id "1"]
             [:times [:time "00:00:01,478"] [:time "00:00:04,020"]]
             [:title "VimeoSrtPlayer Example\n\n"]]
            [:subtitle
             [:id "2"]
             [:times [:time "00:00:05,045"] [:time "00:00:09,545"]]
             [:title "Support for <i>italic</i> font\n\n"]]
            [:subtitle
             [:id "3"]
             [:times [:time "00:00:09,378"] [:time "00:00:13,745"]]
             [:title "Support for <b>bold</b> font\n\n"]]
            [:subtitle
             [:id "4"]
             [:times [:time "00:00:14,812"] [:time "00:00:16,144"]]
             [:title "Multi\nLine\nSupport ;)\n\n"]]
            [:subtitle
             [:id "5"]
             [:times [:time "00:00:18,211"] [:time "00:00:21,211"]]
             [:title "Fonts: DejaVu\nhttp://dejavu-fonts.org\n\n"]]
            [:subtitle
             [:id "6"]
             [:times [:time "00:00:22,278"] [:time "00:00:25,678"]]
             [:title "Dejavu Sans\n\n"]]
            [:subtitle
             [:id "7"]
             [:times [:time "00:00:26,478"] [:time "00:00:31,079"]]
             [:title "<b>DejaVu Sans Condensed Bold</b>\n\n"]]
            [:subtitle
             [:id "8"]
             [:times [:time "00:00:32,144"] [:time "00:00:38,178"]]
             [:title "<i>DejaVu Sans Oblique</i>\n \n"]]
            [:subtitle
             [:id "9"]
             [:times [:time "00:00:39,812"] [:time "00:00:45,745"]]
             [:title "[de.derhess.video.vimeo]\nhttp://blog.derhess.de\n\n"]]
            [:subtitle
             [:id "10"]
             [:times [:time "00:00:46,812"] [:time "00:00:52,745"]]
             [:title "[nl.inlet42.data.subtitles]\nhttp://blog.base42.nl\n\n"]]
            [:subtitle
             [:id "11"]
             [:times [:time "00:00:53,812"] [:time "00:00:59,745"]]
             [:title "[[ VimeoSrtPlayer ]]\nhttp://mindpirates.org\n\n"]]
            [:subtitle
             [:id "12"]
             [:times [:time "00:01:01,812"] [:time "00:01:05,745"]]
             [:title "Video by Kevin Klein\nhttp://vimeo.com/user4167888\n\n"]]
            [:subtitle
             [:id "13"]
             [:times [:time "00:01:06,812"] [:time "00:01:13,745"]]
             [:title "dedicated to\nhttp://problema-thefilm.org\n\n"]]
            [:subtitle
             [:id "14"]
             [:times [:time "00:01:11,812"] [:time "00:01:15,745"]]
             [:title "END OF EXAMPLE FILE"]]]))))