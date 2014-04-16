package com.joe007.practice;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            if (s.length() == 0) {
                return true;
            }
            return false;
        }

        if (s.length() == 0) {
            if (p.length() == 0) {
                return true;
            } else {
                if (p.length() == 1) {
                    return false;
                } else {
                    if (p.charAt(1) == '*') {
                        int i = 2;
                        while (i < p.length()) {
                            if (p.charAt(i) == '*') {
                                i++;
                            } else {
                                break;
                            }
                        }
                        if (i == p.length()) {
                            return true;
                        } else {
                            return isMatch(s, p.substring(i));
                        }

                    } else {
                        return false;
                    }
                }
                // }

            }
        }

        if (p.length() == 1) {
            if (p.equals(".")) {
                return s.length() == 1;
            } else {
                return s.equals(p);
            }
        }

        char s0 = s.charAt(0);
        char p0 = p.charAt(0);
        char p1 = p.charAt(1);

        if (s0 == p0 || p0 == '.') {
            if (p1 != '*') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                // p1 = *
                int i = 2;
                while (i < p.length()) {
                    if (p.charAt(i) == '*') {
                        i++;
                    } else {
                        break;
                    }
                }
                if (i == p.length()) {
                    return isMatch(s.substring(1), p);
                } else {
                    return isMatch(s, p.substring(i))
                            || isMatch(s.substring(1), p);
                }
            }
        } else {
            if (p1 != '*') {
                return false;
            } else {
                int i = 2;
                while (i < p.length()) {
                    if (p.charAt(i) == '*') {
                        i++;
                    } else {
                        break;
                    }
                }
                return isMatch(s, p.substring(i));
            }

        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching instance = new RegularExpressionMatching();
        String s = "a";
        String p = ".*";
        System.out.println(instance.isMatch(s, p));
        // System.out.println(s.substring(2));
    }

}
