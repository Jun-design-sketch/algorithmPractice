package sorting.basicConcept;

public class ShellSort {
    public static void main(String[] args) {
        // ShellSortはInsertionSortを基盤とする。が、
        // InsertionSortの短所を補完するために作られたものとなる。
        // InsertionSortは１つずつ比較をしていくけれど、順番が完全に逆になっていたりしたら
        // その分作業の遂行数自体が増加してしまう。
        // なので、1個ずつ確認していくのではなく空間をおいて幾つかを確認していく。
        // だいたいの位置に配置してあげることで、最悪のケースを避ける

        // 挿入整列と同様に、比較整列（比較するから）でありin-place-sortである。（tmp変数は作るけれどそこまで大きくない）
        // 空間をおいて検査するから安定整列ではない

        // gapを設定する。
        // gap毎に分類された各パートリストについてInsertionSortする。
        // 各パートリストの整列が終わったらgapを少なくする。（〜繰り返し：while gap!=1)
    }
}