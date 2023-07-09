cmake_minimum_required(VERSION 3.23)
project(leetcode)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(leetcode
        merge_sorted_array.cpp
        merge_sorted_array.h)
