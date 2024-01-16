# 기타

## Arrays.parallelSort(병렬 정렬)

Arrays.sort는 내부적으로 퀵정렬을 사용하는데 0(n log(n))의 시간복잡도를 가진다. 그러나 싱글 스레드로 동작하기 때문에 한계가 있습니다.

Java 8부터 Arrays.parallelSort를 사용하여 병렬 정렬을 수행할 수 있습니다. parallelSort는 ForkJoin 프레임워크를 이용하여 배열을 분할하고 각각의 스레드에서 정렬을 수행합니다.
