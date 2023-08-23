package threads.syncronized_and_lock;

/**
 * Чтобы не переписывать Launcher под небезопасный,
 * синхронизированный и залоченный ресурсы
 */
interface SharedResource {
    int calculate(int first, int last);
}
