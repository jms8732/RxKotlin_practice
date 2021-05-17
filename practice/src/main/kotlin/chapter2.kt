import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.util.HalfSerializer.onNext
import io.reactivex.rxjava3.kotlin.toObservable
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.Callable


/*
기록
1. kotlin의 경우, Array를 Observable하려면 toObservable를 이용한다
2. observable는 무수한 데이터를 처리하는 반면 single은 데이터 하나만을 처리한다.
3. AsyncSubject는 onComplete 시점에서 마지막 데이터를 구독자들에게 전달한다.
 3.1 AsyncSubject는 구독자가 될 수도 있고 옵저버블이 될 수 있다.

4. BehaviorSubject는 기본값 혹은 가장 최근 값을 전달한다.
*/
fun main(args: Array<String>) {
    var subject = BehaviorSubject.create<String>()
    subject.subscribe { v -> println("subscriber #1 $v") }
    subject.onNext("1")
    subject.subscribe { v -> println("subscriber #2 $v") }
    subject.onComplete()
}